import dev.simonestefani.ktor.sql.DBConnected
import io.ktor.application.Application
import io.ktor.application.ApplicationEvents
import io.ktor.application.ApplicationFeature
import io.ktor.util.AttributeKey
import org.ktorm.database.Database
import org.ktorm.global.connectGlobally
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel

class KtormFeature private constructor(
    monitor: ApplicationEvents,
    config: Config
) {
    init {
        val (init) = config
        monitor.subscribe(DBConnected) {
            Database.connectGlobally(dataSource = it, logger = ConsoleLogger(threshold = LogLevel.ERROR))
            init()
        }
    }

    class Config {
        private var init: () -> Unit = {}

        internal operator fun component1() = init

        fun init(init: () -> Unit) {
            this.init = init
        }
    }

    companion object Feature : ApplicationFeature<Application, Config, KtormFeature> {
        override val key: AttributeKey<KtormFeature> = AttributeKey("Ktorm")

        override fun install(pipeline: Application, configure: Config.() -> Unit): KtormFeature {
            return KtormFeature(pipeline.environment.monitor, Config().apply(configure))
        }
    }
}

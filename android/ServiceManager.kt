import com.yu.android.sm.interfaces.IService
import java.util.concurrent.ConcurrentHashMap

class ServiceManager {
    companion object {
        private val MAP = ConcurrentHashMap<Class<out IService>, IService>()

        fun <T : IService> addService(clazz: Class<out IService>, service: T) {
            if (!MAP.containsKey(clazz)) {
                MAP[clazz] = service
            }
        }

        fun <T : IService> getService(clazz: Class<T>): T {
            return MAP[clazz] as T
        }
    }
}
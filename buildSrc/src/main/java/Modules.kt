object Modules {

    const val data = ":data"
    const val domain = ":domain"

    object Common {
        const val ui = ":common:ui"
        const val utils = ":common:utils"
    }
    object Core {
        const val di = ":core:di"
        const val network = ":core:network"
        const val navApi = ":core:navigation:api"
        const val navImpl = ":core:navigation:impl"
    }

    object Features {
        const val home = ":features:home"
        const val details = ":features:details"
    }
}
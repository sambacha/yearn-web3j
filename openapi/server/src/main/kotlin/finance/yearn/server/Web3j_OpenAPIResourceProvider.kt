package finance.yearn.server

import javax.annotation.Generated
import org.web3j.openapi.server.spi.OpenApiResourceProvider

@Generated
class Web3j_OpenAPIResourceProvider : OpenApiResourceProvider {
    override fun get() = Web3j_OpenAPIApiImpl::class.java
}

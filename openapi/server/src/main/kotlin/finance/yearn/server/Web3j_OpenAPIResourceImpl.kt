package finance.yearn.server

import finance.yearn.core.Web3j_OpenAPIResource
import finance.yearn.server.ivault.IVaultLifecycleImpl
import javax.annotation.Generated
import org.glassfish.jersey.server.ExtendedUriInfo
import org.web3j.openapi.server.SubResourceImpl
import org.web3j.openapi.server.config.ContractAddresses
import org.web3j.protocol.Web3j
import org.web3j.tx.TransactionManager
import org.web3j.tx.gas.ContractGasProvider

@Generated
class Web3j_OpenAPIResourceImpl(
    web3j: Web3j,
    transactionManager: TransactionManager,
    defaultGasProvider: ContractGasProvider,
    contractAddresses: ContractAddresses,
    uriInfo: ExtendedUriInfo
) : Web3j_OpenAPIResource, SubResourceImpl(uriInfo) {

    override val iVault = IVaultLifecycleImpl(
        web3j,
        transactionManager,
        defaultGasProvider,
        contractAddresses["IVault"],
        uriInfo
    )
}

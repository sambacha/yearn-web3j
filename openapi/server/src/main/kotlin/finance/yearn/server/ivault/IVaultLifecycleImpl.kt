package finance.yearn.server.ivault

import finance.yearn.core.ivault.IVaultLifecycle
import finance.yearn.wrappers.IVault
import javax.annotation.Generated
import javax.ws.rs.Consumes
import javax.ws.rs.NotFoundException
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import org.glassfish.jersey.server.ExtendedUriInfo
import org.web3j.abi.datatypes.Address
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.tx.TransactionManager
import org.web3j.tx.gas.ContractGasProvider

@Generated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class IVaultLifecycleImpl(
    private val web3j: Web3j,
    private val transactionManager: TransactionManager,
    private val defaultGasProvider: ContractGasProvider,
    private val contractAddress: Address?,
    private val uriInfo: ExtendedUriInfo
) : IVaultLifecycle {

    override fun deploy(): TransactionReceipt {
        val iVault = IVault.deploy(
            web3j,
            transactionManager,
            defaultGasProvider

        ).send()

        return iVault.transactionReceipt.get()
    }

    override fun load(contractAddress: String) =
        IVaultResourceImpl(
            IVault.load(contractAddress, web3j, transactionManager, defaultGasProvider),
            uriInfo
        )

    override fun load() = contractAddress?.run { load(contractAddress.value) } ?: throw NotFoundException("Contract address not defined!")
}

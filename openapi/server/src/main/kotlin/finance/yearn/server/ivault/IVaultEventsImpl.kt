package finance.yearn.server.ivault

import finance.yearn.core.ivault.IVaultEvents
import finance.yearn.server.ivault.eventsImpl.ApprovalEventResourceImpl
import finance.yearn.server.ivault.eventsImpl.TransferEventResourceImpl
import finance.yearn.wrappers.IVault
import javax.annotation.Generated
import org.glassfish.jersey.server.ExtendedUriInfo
import org.web3j.openapi.server.SubResourceImpl

@Generated
class IVaultEventsImpl(
    private val iVault: IVault,
    uriInfo: ExtendedUriInfo
) : IVaultEvents, SubResourceImpl(uriInfo) {

    override val approvalEvents: ApprovalEventResourceImpl = ApprovalEventResourceImpl(iVault)
    override val transferEvents: TransferEventResourceImpl = TransferEventResourceImpl(iVault)
}

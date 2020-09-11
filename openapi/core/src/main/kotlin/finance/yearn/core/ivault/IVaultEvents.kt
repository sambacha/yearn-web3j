package finance.yearn.core.ivault

import finance.yearn.core.ivault.events.ApprovalEventResource
import finance.yearn.core.ivault.events.TransferEventResource
import javax.annotation.Generated
import javax.ws.rs.Path
import org.web3j.openapi.core.SubResource

@Generated
interface IVaultEvents : SubResource {
    @get:Path("ApprovalEvents")
    val approvalEvents: ApprovalEventResource

    @get:Path("TransferEvents")
    val transferEvents: TransferEventResource
}

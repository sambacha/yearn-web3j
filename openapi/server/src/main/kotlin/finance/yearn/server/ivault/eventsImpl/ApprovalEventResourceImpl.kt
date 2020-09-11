package finance.yearn.server.ivault.eventsImpl

import finance.yearn.core.ivault.events.ApprovalEventResource
import finance.yearn.core.ivault.model.ApprovalEventResponse
import finance.yearn.wrappers.IVault
import finance.yearn.wrappers.IVault.APPROVAL_EVENT
import javax.annotation.Generated
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.sse.Sse
import javax.ws.rs.sse.SseEventSink
import org.web3j.openapi.core.models.TransactionReceiptModel
import org.web3j.openapi.server.SseUtils
import org.web3j.protocol.core.methods.request.EthFilter

@Generated
class ApprovalEventResourceImpl(
    private val iVault: IVault
) : ApprovalEventResource {

    override fun findBy(transactionReceiptModel: TransactionReceiptModel):
    List<ApprovalEventResponse> {
        val eventResponse = iVault.getApprovalEvents(
            transactionReceiptModel.toTransactionReceipt()
        )
        return eventResponse.map { ApprovalEventResponse(it.owner, it.spender, it.value) }
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    fun subscribe(@Context eventSink: SseEventSink, @Context sse: Sse) {
        val flowable = iVault.approvalEventFlowable(EthFilter())
        val eventClass = IVault.ApprovalEventResponse::class.java
        SseUtils.subscribe(APPROVAL_EVENT, eventClass, flowable, eventSink, sse) {
            ApprovalEventResponse(it.owner, it.spender, it.value)
        }
    }
}

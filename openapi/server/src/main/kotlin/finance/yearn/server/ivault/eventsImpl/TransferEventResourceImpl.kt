package finance.yearn.server.ivault.eventsImpl

import finance.yearn.core.ivault.events.TransferEventResource
import finance.yearn.core.ivault.model.TransferEventResponse
import finance.yearn.wrappers.IVault
import finance.yearn.wrappers.IVault.TRANSFER_EVENT
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
class TransferEventResourceImpl(
    private val iVault: IVault
) : TransferEventResource {

    override fun findBy(transactionReceiptModel: TransactionReceiptModel):
    List<TransferEventResponse> {
        val eventResponse = iVault.getTransferEvents(
            transactionReceiptModel.toTransactionReceipt()
        )
        return eventResponse.map { TransferEventResponse(it.from, it.to, it.value) }
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    fun subscribe(@Context eventSink: SseEventSink, @Context sse: Sse) {
        val flowable = iVault.transferEventFlowable(EthFilter())
        val eventClass = IVault.TransferEventResponse::class.java
        SseUtils.subscribe(TRANSFER_EVENT, eventClass, flowable, eventSink, sse) {
            TransferEventResponse(it.from, it.to, it.value)
        }
    }
}

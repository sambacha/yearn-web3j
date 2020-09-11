package finance.yearn.core.ivault.events

import finance.yearn.core.ivault.model.TransferEventResponse
import io.swagger.v3.oas.annotations.Operation
import java.util.concurrent.CompletableFuture
import javax.annotation.Generated
import javax.ws.rs.POST
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import org.web3j.openapi.core.EventResource

@Generated
interface TransferEventResource : EventResource<TransferEventResponse> {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        tags = ["IVault Events"],
        summary = "Get the Transfer event"
    )
    override fun findBy(transactionReceiptModel: org.web3j.openapi.core.models.TransactionReceiptModel):
    List<TransferEventResponse>

    override fun onEvent(onEvent: (TransferEventResponse) -> Unit): CompletableFuture<Void> =
        CompletableFuture.completedFuture(null)
}

package finance.yearn.core.ivault

import finance.yearn.core.ivault.model.AllowanceParameters
import finance.yearn.core.ivault.model.ApproveParameters
import finance.yearn.core.ivault.model.BalanceOfParameters
import finance.yearn.core.ivault.model.DepositParameters
import finance.yearn.core.ivault.model.TransferFromParameters
import finance.yearn.core.ivault.model.TransferParameters
import finance.yearn.core.ivault.model.WithdrawParameters
import io.swagger.v3.oas.annotations.Operation
import javax.annotation.Generated
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Generated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
interface IVaultResource {

    @get:Path("events")
    val events: IVaultEvents

    @POST
    @Path("Allowance")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the Allowance method")
    fun allowance(allowanceParameters: AllowanceParameters): org.web3j.openapi.core.models.ResultModel<java.math.BigInteger>

    @POST
    @Path("Approve")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the Approve method")
    fun approve(approveParameters: ApproveParameters): org.web3j.openapi.core.models.TransactionReceiptModel

    @POST
    @Path("BalanceOf")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the BalanceOf method")
    fun balanceOf(balanceOfParameters: BalanceOfParameters): org.web3j.openapi.core.models.ResultModel<java.math.BigInteger>

    @GET
    @Path("ClaimInsurance")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the ClaimInsurance method")
    fun claimInsurance(): org.web3j.openapi.core.models.TransactionReceiptModel

    @POST
    @Path("Deposit")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the Deposit method")
    fun deposit(depositParameters: DepositParameters): org.web3j.openapi.core.models.TransactionReceiptModel

    @GET
    @Path("GetPricePerFullShare")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the GetPricePerFullShare method")
    fun getPricePerFullShare(): org.web3j.openapi.core.models.ResultModel<java.math.BigInteger>

    @GET
    @Path("Token")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the Token method")
    fun token(): org.web3j.openapi.core.models.ResultModel<kotlin.String>

    @GET
    @Path("TotalSupply")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the TotalSupply method")
    fun totalSupply(): org.web3j.openapi.core.models.ResultModel<java.math.BigInteger>

    @POST
    @Path("Transfer")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the Transfer method")
    fun transfer(transferParameters: TransferParameters): org.web3j.openapi.core.models.TransactionReceiptModel

    @POST
    @Path("TransferFrom")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the TransferFrom method")
    fun transferFrom(transferFromParameters: TransferFromParameters): org.web3j.openapi.core.models.TransactionReceiptModel

    @POST
    @Path("Withdraw")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(tags = ["IVault Methods"], summary = "Execute the Withdraw method")
    fun withdraw(withdrawParameters: WithdrawParameters): org.web3j.openapi.core.models.TransactionReceiptModel
}

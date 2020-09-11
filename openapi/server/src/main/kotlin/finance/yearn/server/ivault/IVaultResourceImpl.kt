package finance.yearn.server.ivault

import finance.yearn.core.ivault.IVaultEvents
import finance.yearn.core.ivault.IVaultResource
import finance.yearn.core.ivault.model.AllowanceParameters
import finance.yearn.core.ivault.model.ApproveParameters
import finance.yearn.core.ivault.model.BalanceOfParameters
import finance.yearn.core.ivault.model.DepositParameters
import finance.yearn.core.ivault.model.TransferFromParameters
import finance.yearn.core.ivault.model.TransferParameters
import finance.yearn.core.ivault.model.WithdrawParameters
import finance.yearn.wrappers.IVault
import java.math.BigInteger
import kotlin.String
import org.glassfish.jersey.server.ExtendedUriInfo
import org.web3j.openapi.core.models.ResultModel
import org.web3j.openapi.core.models.TransactionReceiptModel

class IVaultResourceImpl(
    private val iVault: IVault,
    private val uriInfo: ExtendedUriInfo
) : IVaultResource {
    override val events: IVaultEvents = IVaultEventsImpl(iVault, uriInfo)

    override fun allowance(allowanceParameters: AllowanceParameters): ResultModel<BigInteger> =
        org.web3j.openapi.core.models.ResultModel(
            iVault.allowance(
                allowanceParameters.owner, allowanceParameters.spender
            ).send()
        )
    override fun approve(approveParameters: ApproveParameters): TransactionReceiptModel =
        TransactionReceiptModel(
            iVault.approve(
                approveParameters.spender, approveParameters.amount
            ).send()
        )
    override fun balanceOf(balanceOfParameters: BalanceOfParameters): ResultModel<BigInteger> =
        org.web3j.openapi.core.models.ResultModel(
            iVault.balanceOf(
                balanceOfParameters.account
            ).send()
        )
    override fun claimInsurance(): TransactionReceiptModel =
        TransactionReceiptModel(iVault.claimInsurance().send())
    override fun deposit(depositParameters: DepositParameters): TransactionReceiptModel =
        TransactionReceiptModel(
            iVault.deposit(
                depositParameters.input0
            ).send()
        )
    override fun getPricePerFullShare(): ResultModel<BigInteger> =
        org.web3j.openapi.core.models.ResultModel(iVault.getPricePerFullShare().send())
    override fun token(): ResultModel<String> =
        org.web3j.openapi.core.models.ResultModel(iVault.token().send())
    override fun totalSupply(): ResultModel<BigInteger> =
        org.web3j.openapi.core.models.ResultModel(iVault.totalSupply().send())
    override fun transfer(transferParameters: TransferParameters): TransactionReceiptModel =
        TransactionReceiptModel(
            iVault.transfer(
                transferParameters.recipient, transferParameters.amount
            ).send()
        )
    override fun transferFrom(transferFromParameters: TransferFromParameters): TransactionReceiptModel =
        TransactionReceiptModel(
            iVault.transferFrom(

                transferFromParameters.sender, transferFromParameters.recipient, transferFromParameters.amount
            ).send()
        )
    override fun withdraw(withdrawParameters: WithdrawParameters): TransactionReceiptModel =
        TransactionReceiptModel(
            iVault.withdraw(
                withdrawParameters.input0
            ).send()
        )
}

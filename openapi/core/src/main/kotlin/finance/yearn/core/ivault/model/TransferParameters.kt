package finance.yearn.core.ivault.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger
import kotlin.String

data class TransferParameters(
  @JsonProperty(value = "recipient")
  val recipient: String,
  @JsonProperty(value = "amount")
  val amount: BigInteger
)

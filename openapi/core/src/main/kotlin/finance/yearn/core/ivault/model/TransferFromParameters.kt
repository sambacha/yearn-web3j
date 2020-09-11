package finance.yearn.core.ivault.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger
import kotlin.String

data class TransferFromParameters(
  @JsonProperty(value = "sender")
  val sender: String,
  @JsonProperty(value = "recipient")
  val recipient: String,
  @JsonProperty(value = "amount")
  val amount: BigInteger
)

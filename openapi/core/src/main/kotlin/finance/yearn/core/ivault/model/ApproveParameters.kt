package finance.yearn.core.ivault.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger
import kotlin.String

data class ApproveParameters(
  @JsonProperty(value = "spender")
  val spender: String,
  @JsonProperty(value = "amount")
  val amount: BigInteger
)

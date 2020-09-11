package finance.yearn.core.ivault.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger
import kotlin.String

data class ApprovalEventResponse(
  @JsonProperty(value = "owner")
  val owner: String,
  @JsonProperty(value = "spender")
  val spender: String,
  @JsonProperty(value = "value")
  val value: BigInteger
)

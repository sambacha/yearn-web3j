package finance.yearn.core.ivault.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger
import kotlin.String

data class TransferEventResponse(
  @JsonProperty(value = "from")
  val from: String,
  @JsonProperty(value = "to")
  val to: String,
  @JsonProperty(value = "value")
  val value: BigInteger
)

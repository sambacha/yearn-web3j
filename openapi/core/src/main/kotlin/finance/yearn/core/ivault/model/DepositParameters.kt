package finance.yearn.core.ivault.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger

data class DepositParameters(
  @JsonProperty(value = "input0")
  val input0: BigInteger
)

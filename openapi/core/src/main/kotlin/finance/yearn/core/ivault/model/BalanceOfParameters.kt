package finance.yearn.core.ivault.model

import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.String

data class BalanceOfParameters(
  @JsonProperty(value = "account")
  val account: String
)

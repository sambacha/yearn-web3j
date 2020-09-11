package finance.yearn.core.ivault.model

import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.String

data class AllowanceParameters(
  @JsonProperty(value = "owner")
  val owner: String,
  @JsonProperty(value = "spender")
  val spender: String
)

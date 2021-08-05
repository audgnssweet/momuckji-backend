package momuckji.com.backend.infra.searchCommon

import org.springframework.util.MultiValueMap

interface Queryable {
    fun makeQueryParams(): MultiValueMap<String, String>
}

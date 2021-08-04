package momuckji.com.backend.domain.service

interface RestaurantSearcher <Req, Res> {
    fun search(req: Req): Res
}
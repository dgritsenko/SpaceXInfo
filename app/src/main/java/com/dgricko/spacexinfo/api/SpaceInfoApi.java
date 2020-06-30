package com.dgricko.spacexinfo.api;

import com.dgricko.spacexinfo.api.model.CrewDTO;
import com.dgricko.spacexinfo.api.model.DragonDTO;
import com.dgricko.spacexinfo.api.model.RocketDTO;
import com.dgricko.spacexinfo.api.model.ShipDTO;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface SpaceInfoApi {

    @GET("rockets")
    Single<List<RocketDTO>> getRockets();

/*    @GET("rockets/{id}")
      Single<RocketDTO> getRocketForId(@Path("id") String id);*/

    @GET("dragons")
    Single<List<DragonDTO>> getDragons();

    @GET("crew")
    Single<List<CrewDTO>> getCrews();

    @GET("ships")
    Single<List<ShipDTO>> getShips();

}

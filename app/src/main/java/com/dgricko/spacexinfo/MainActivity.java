package com.dgricko.spacexinfo;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dgricko.spacexinfo.api.model.CrewDTO;
import com.dgricko.spacexinfo.api.model.DragonDTO;
import com.dgricko.spacexinfo.api.model.RocketDTO;
import com.dgricko.spacexinfo.api.model.ShipDTO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    CompositeDisposable disposable = new CompositeDisposable();


    private List<RocketDTO>rockets;
    private List<DragonDTO>dragons;
    private List<CrewDTO>crews;
    private List<ShipDTO>ships;

    private List<String> imagesForGallery;

    public List<String> getImagesForGallery() {
        return imagesForGallery;
    }

    public void setImagesForGallery(List<String> imagesForGallery) {
        this.imagesForGallery = imagesForGallery;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initStrictMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App app = (App) getApplication();


        disposable.add(app.getSpaceInfoService().getApi().getRockets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BiConsumer<List<RocketDTO>, Throwable>() {
                    @Override
                    public void accept(List<RocketDTO> rocketDTOS, Throwable throwable) throws Exception {
                        if (throwable != null) {
                            Toast.makeText(MainActivity.this, "Data loading error", Toast.LENGTH_SHORT).show();
                        }else {
                            System.out.println("!Test: "+ rocketDTOS);
                            rockets = rocketDTOS;
                        }
                    }


                }));

        disposable.add(app.getSpaceInfoService().getApi().getDragons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BiConsumer<List<DragonDTO>, Throwable>() {
                    @Override
                    public void accept(List<DragonDTO> dragonDTOS, Throwable throwable) throws Exception {
                        if (throwable!=null){
                            Toast.makeText(MainActivity.this, "Data loading error", Toast.LENGTH_SHORT).show();
                        }else {
                            dragons = dragonDTOS;
                        }
                    }
                }));

        disposable.add(app.getSpaceInfoService().getApi().getCrews().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new BiConsumer<List<CrewDTO>, Throwable>() {
            @Override
            public void accept(List<CrewDTO> crewDTOS, Throwable throwable) throws Exception {
                if (throwable!=null){
                    Toast.makeText(MainActivity.this, "Data loading error", Toast.LENGTH_SHORT).show();
                }else {
                    crews = crewDTOS;
                }
            }
        }));

        disposable.add(app.getSpaceInfoService().getApi().getShips().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new BiConsumer<List<ShipDTO>, Throwable>() {
            @Override
            public void accept(List<ShipDTO> shipDTOS, Throwable throwable) throws Exception {
                if (throwable!=null){
                    Toast.makeText(MainActivity.this, "Data loading error", Toast.LENGTH_SHORT).show();
                }else {
                    ships = shipDTOS;
                }
            }
        }));

    }
    private void initStrictMode(){

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()

                .detectAll()
                .penaltyLog()
                .build());
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();

    }

    public List<RocketDTO> getRockets(){
        return rockets;
    }

    public List<DragonDTO> getDragons(){
        return dragons;
    }

    public List<CrewDTO> getCrews(){return crews;}

    public List<ShipDTO> getShips(){
        return ships;
    }



    public List<String> getAllPhotoFromDragons(){
        List<String> allImgs = new ArrayList<>();
        for (int i = 0; i<dragons.size();i++){

            for (String imgages: dragons.get(i).getFlickr_images()){
                allImgs.add((String) imgages);
            }
        }
        return allImgs;
    }

    public List<String> getAllPhotoFromRockets(){
        List<String> allImgs = new ArrayList<>();
        for (int i = 0; i<rockets.size();i++){

            for (String imgages: rockets.get(i).getFlickr_images()){
                allImgs.add((String) imgages);
            }
        }
        return allImgs;
    }

    public List<String> getAllPhotoFromShips(){
        List<String> allImgs = new ArrayList<>();
        for (int i = 0; i<ships.size();i++){
            allImgs.add(ships.get(i).getImage());
        }
        return allImgs;
    }

    public List<String> getAllPhotoFromCrew(){
        List<String> allImgs = new ArrayList<>();
        for (int i = 0; i<crews.size();i++){
            allImgs.add(crews.get(i).getImage());
        }
        return allImgs;
    }

}
package com.dgricko.spacexinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.dgricko.spacexinfo.api.model.CrewDTO;
import com.dgricko.spacexinfo.api.model.DragonDTO;
import com.dgricko.spacexinfo.api.model.RocketDTO;
import com.dgricko.spacexinfo.api.model.ShipDTO;

import java.util.List;

import io.reactivex.Scheduler;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}
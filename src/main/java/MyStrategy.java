import model.*;

import java.util.ArrayList;
import java.util.List;

public final class MyStrategy implements Strategy {

    Vehicles vehicles; // хранит в себе данные о всех юнитах

    @Override
    public void move(Player me, World world, Game game, Move move) {
        // в первый ход - инициализируем
        if (world.getTickIndex() == 0) {
            initialize();
        }

        // каждый ход проверяем:
        vehicles.add(world.getNewVehicles()); // появились ли новые юниты
        vehicles.addUpdates(world.getVehicleUpdates()); // изменилось ли чего со старыми

        // в первые два хода - посылаем юнитов к сооружениям
        if (world.getTickIndex() <= 1) {
            sendUnitsToFacilities(world, move, me);
        }
    }

    /*
     * Метод выполняется в первый ход (на 0 тике).
     * Здесь нужно создавать глобальные переменные, заполнять их стартовыми значениями и так далее.
     */
    void initialize() {
        vehicles = new Vehicles();
    }

    /**
     * Метод посылает юнитов к сооружениям.
     */
    void sendUnitsToFacilities(World world, Move move, Player me) {
        // получаем список сооржуний (отсортированный по дальности от левого верхнего угла карты)
        List<Facility> facilities = world.getSortedFacilities(0, 0);
        for (Facility facility : facilities) {
            //ищем ближайшего юнита
           Vehicle nearVeh =  vehicles.getNearestToFacility(facility, me.getId(), VehicleType.FIGHTER);

        }

    }

}
import model.*;

import java.util.List;

public final class MyStrategy implements Strategy {
    Vehicles vehicles;
    @Override
    public void move(Player me, World world, Game game, Move move) {
        if (world.getTickIndex() == 0) {
            initialize();
        }
        vehicles.add(world.getNewVehicles());
        vehicles.addUpdates(world.getVehicleUpdates());
        if (world.getTickIndex() <= 1) {
            sendUnitsToFacilities(world, move);
        }
    }
    void initialize() {
        vehicles = new Vehicles();
    }
    void sendUnitsToFacilities(World world, Move move) {
        List<Facility> facilities = world.getSortedFacilities(0, 0);
        Facility bs = facilities.get(0);
        if (world.getTickIndex() == 0) {
            move.setAction(ActionType.CLEAR_AND_SELECT);
            move.setRight(world.getWidth());
            move.setBottom(world.getHeight());
            return;
        }

        if (world.getTickIndex() == 1) {
            move.setAction(ActionType.MOVE);
            move.setX(bs.getLeft());
            move.setY(bs.getTop());
        }
    }

}

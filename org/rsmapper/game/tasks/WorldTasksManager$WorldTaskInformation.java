//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.tasks;

final class WorldTasksManager$WorldTaskInformation {
    private WorldTask task;
    private int continueMaxCount;
    private int continueCount;

    public WorldTasksManager$WorldTaskInformation(WorldTask task, int continueCount, int continueMaxCount) {
        this.task = task;
        this.continueCount = continueCount;
        this.continueMaxCount = continueMaxCount;
        if (continueMaxCount == -1) {
            task.needRemove = true;
        }

    }
}

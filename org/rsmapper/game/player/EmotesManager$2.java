//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.Animation;
import org.rsmapper.game.Entity;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.tasks.WorldTask;

class EmotesManager$2 extends WorldTask {
    private int step;
    private NPC npc;

    EmotesManager$2(EmotesManager var1, WorldTile var2) {
        this.this$0 = var1;
        this.val$npcTile = var2;
    }

    public void run() {
        if (this.step == 0) {
            this.npc = new NPC(1224, this.val$npcTile, -1, true);
            this.npc.setNextAnimation(new Animation(1434));
            this.npc.setNextGraphics(new Graphics(1482));
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(1179));
            this.npc.setNextFaceEntity(EmotesManager.access$0(this.this$0));
            EmotesManager.access$0(this.this$0).setNextFaceEntity(this.npc);
        } else if (this.step == 2) {
            this.npc.setNextAnimation(new Animation(1436));
            this.npc.setNextGraphics(new Graphics(1486));
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(1180));
        } else if (this.step == 3) {
            this.npc.setNextGraphics(new Graphics(1498));
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(1181));
        } else if (this.step == 4) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(1182));
        } else if (this.step == 5) {
            this.npc.setNextAnimation(new Animation(1448));
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(1250));
        } else if (this.step == 6) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(1251));
            EmotesManager.access$0(this.this$0).setNextGraphics(new Graphics(1499));
            this.npc.setNextAnimation(new Animation(1454));
            this.npc.setNextGraphics(new Graphics(1504));
        } else if (this.step == 11) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(1291));
            EmotesManager.access$0(this.this$0).setNextGraphics(new Graphics(1686));
            EmotesManager.access$0(this.this$0).setNextGraphics(new Graphics(1598));
            this.npc.setNextAnimation(new Animation(1440));
        } else if (this.step == 16) {
            EmotesManager.access$0(this.this$0).setNextFaceEntity((Entity)null);
            this.npc.finish();
            this.stop();
        }

        ++this.step;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.Animation;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.tasks.WorldTask;

class EmotesManager$3 extends WorldTask {
    private int step;

    EmotesManager$3(EmotesManager var1, int var2) {
        this.this$0 = var1;
        this.val$capeId = var2;
    }

    public void run() {
        if (this.step == 0) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(356));
            EmotesManager.access$0(this.this$0).setNextGraphics(new Graphics(307));
        } else if (this.step == 2) {
            EmotesManager.access$0(this.this$0).getAppearence().transformIntoNPC(this.val$capeId == 20769 ? 1830 : 3372);
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(1174));
            EmotesManager.access$0(this.this$0).setNextGraphics(new Graphics(1443));
        } else if (this.step == 4) {
            EmotesManager.access$0(this.this$0).getPackets().sendCameraShake(3, 25, 50, 25, 50);
        } else if (this.step == 5) {
            EmotesManager.access$0(this.this$0).getPackets().sendStopCameraShake();
        } else if (this.step == 8) {
            EmotesManager.access$0(this.this$0).getAppearence().transformIntoNPC(-1);
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(1175));
            this.stop();
        }

        ++this.step;
    }
}

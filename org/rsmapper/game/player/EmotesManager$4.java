//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.Animation;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.tasks.WorldTask;

class EmotesManager$4 extends WorldTask {
    private int step;

    EmotesManager$4(EmotesManager var1) {
        this.this$0 = var1;
    }

    public void run() {
        if (this.step == 0) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(10994));
            EmotesManager.access$0(this.this$0).setNextGraphics(new Graphics(86));
        } else if (this.step == 1) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(10996));
            EmotesManager.access$0(this.this$0).getAppearence().transformIntoNPC(8499);
        } else if (this.step == 6) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(10995));
            EmotesManager.access$0(this.this$0).setNextGraphics(new Graphics(86));
            EmotesManager.access$0(this.this$0).getAppearence().transformIntoNPC(-1);
            this.stop();
        }

        ++this.step;
    }
}

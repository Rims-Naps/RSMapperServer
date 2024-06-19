//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.Animation;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.tasks.WorldTask;

class EmotesManager$5 extends WorldTask {
    int random;
    private int step;

    EmotesManager$5(EmotesManager var1) {
        this.this$0 = var1;
        this.random = (int)(Math.random() * 3.0);
    }

    public void run() {
        if (this.step == 0) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(15104));
            EmotesManager.access$0(this.this$0).setNextGraphics(new Graphics(1287));
        } else if (this.step == 1) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(15106));
            EmotesManager.access$0(this.this$0).getAppearence().transformIntoNPC(this.random == 0 ? 13255 : (this.random == 1 ? 13256 : 13257));
        } else if (this.step == 2) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(15108));
        } else if (this.step == 3) {
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(15105));
            EmotesManager.access$0(this.this$0).setNextGraphics(new Graphics(1287));
            EmotesManager.access$0(this.this$0).getAppearence().transformIntoNPC(-1);
            this.stop();
        }

        ++this.step;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.Animation;
import org.rsmapper.game.tasks.WorldTask;

class EmotesManager$1 extends WorldTask {
    int step;

    EmotesManager$1(EmotesManager var1, int var2) {
        this.this$0 = var1;
        this.val$rand = var2;
    }

    public void run() {
        if (this.step == 1) {
            EmotesManager.access$0(this.this$0).getAppearence().transformIntoNPC(this.val$rand == 0 ? 11227 : (this.val$rand == 1 ? 11228 : 11229));
            EmotesManager.access$0(this.this$0).setNextAnimation(new Animation(this.val$rand > 0 ? 13192 : (this.val$rand == 1 ? 13193 : 13194)));
        }

        if (this.step == 3) {
            EmotesManager.access$0(this.this$0).getAppearence().transformIntoNPC(-1);
            this.stop();
        }

        ++this.step;
    }
}

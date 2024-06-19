//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.engine.game;

import java.io.IOException;
import java.util.concurrent.Executors;
import org.rsmapper.api.event.EventManager;
import org.rsmapper.cache.Cache;
import org.rsmapper.engine.BlockingExecutorService;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.engine.process.ProcessManagement;
import org.rsmapper.engine.service.login.LoginService;
import org.rsmapper.game.RegionBuilder;
import org.rsmapper.game.World;
import org.rsmapper.game.player.controlers.ControllerHandler;
import org.rsmapper.game.player.cutscenes.CutscenesHandler;
import org.rsmapper.networking.ServerChannelHandler;
import org.rsmapper.networking.packet.PacketSystem;
import org.rsmapper.utilities.game.cache.MapXTEA;
import org.rsmapper.utilities.misc.DateManager;
import org.rsmapper.utilities.security.Huffman;

public class GameLoader {
    private final BlockingExecutorService backgroundLoader = new BlockingExecutorService(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
    private static final GameLoader LOADER = new GameLoader();

    public GameLoader() {
        this.load();
    }

    public static GameLoader get() {
        return LOADER;
    }

    public BlockingExecutorService getBackgroundLoader() {
        return this.backgroundLoader;
    }

    public void load() {
        DateManager.get().setTime();

        try {
            Cache.init();
            CoresManager.init();
            ServerChannelHandler.init();
            World.init();
        } catch (IOException var2) {
            IOException e = var2;
            e.printStackTrace();
        }

        this.getBackgroundLoader().submit(() -> {
            Huffman.init();
            return null;
        });
        this.getBackgroundLoader().submit(() -> {
            MapXTEA.init();
            return null;
        });
        this.getBackgroundLoader().submit(() -> {
            PacketSystem.load();
            return null;
        });
        this.getBackgroundLoader().submit(() -> {
            ControllerHandler.init();
            CutscenesHandler.init();
            return null;
        });
        this.getBackgroundLoader().submit(() -> {
            RegionBuilder.init();
            return null;
        });
        this.getBackgroundLoader().submit(() -> {
            ProcessManagement.get().registerEvents();
            return null;
        });
        this.getBackgroundLoader().submit(() -> {
            EventManager.get().load();
            LoginService.getSingleton().init();
            return null;
        });
    }
}

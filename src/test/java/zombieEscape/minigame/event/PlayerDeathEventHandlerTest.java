package zombieEscape.minigame.event;

public class PlayerDeathEventHandlerTest {
    private ServerMock server;
    private Plugin plugin;
    private ZombieEscapeMinigame game;

    @BeforeEach
    public void setUp() {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(TestPlugin.class);
        // Create a dummy GameConfig for initialization (you can create a minimal one)
        game = new ZombieEscapeMinigame(plugin, DummyConfig.get());
        game.init();
    }

    @AfterEach
    public void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    public void testPlayerDeathRemovesParticipant() {
        PlayerMock player = server.addPlayer();
        game.addParticipant(player);
        // Simulate player death
        PlayerDeathEvent deathEvent = new PlayerDeathEvent(player, null, 0.0, "");
        server.getPluginManager().callEvent(deathEvent);

        // After death, the player should be removed from participants.
        assertFalse(game.isParticipant(player), "Player should be removed after death");
    }
}

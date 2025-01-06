package Screen;



public abstract class BaseScreen implements Screen {
    protected final MyGame game;
    protected SpriteBatch batch;
    protected OrthographicCamera camera;

    public BaseScreen(MyGame game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
    }

    // Implementacja podstawowych metod Screen
    @Override
    public void render(float delta) {
        // Podstawowe czyszczenie ekranu
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.position.set(width/2f, height/2f, 0);
    }

    // Inne metody Screen...
}

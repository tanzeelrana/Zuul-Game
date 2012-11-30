package editor;

import editor.controller.EditorListener;
import editor.model.LevelEditor;
import editor.view.EditorView;


public class EditorDriver {
	
	private static EditorListener mouseListener;
	private static EditorView view;
	private static LevelEditor model;
	
	public EditorDriver(int x, int y) {
		mouseListener = new EditorListener();
		model = new LevelEditor(x, y);
		
		view = new EditorView("Zuul Level Editor",x,y,mouseListener, model.getItems(), model.getMonsters());
		
		mouseListener.addObserver(model);
		model.addObserver(view);
		view.addObserver(model);
	}
	
	public void show() {
		view.show();
	}

}

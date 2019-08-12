package oxq.action.game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServerObject2 {
	private ServerSocket ss; 
	public ArrayList<GameHandlerObject> list;

	public GameServerObject2() {
		try {
			ss = new ServerSocket(2000);
			System.out.println("2번 게임방 서버 준비 완료");

			list = new ArrayList<GameHandlerObject>();

			while (true) {
				Socket socket = ss.accept();
				GameHandlerObject handler = new GameHandlerObject(socket, list);
				handler.start();
			
				list.add(handler);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new GameServerObject2();
	}
}

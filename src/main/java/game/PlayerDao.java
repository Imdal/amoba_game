package game;

import javax.transaction.Transactional;
import java.util.List;
import util.jpa.GenericJpaDao;

import java.util.List;

public class PlayerDao extends util.jpa.GenericJpaDao<Player> {
    public PlayerDao() {
        super(Player.class);
    }

@Transactional
    public Player findPlayer(String name){
        if(entityManager.createQuery("Select playerName From Player p where p.playerName=name").getResultList().isEmpty()){
            return null;
        }
        else return (Player) entityManager.createQuery("Select playerName From Player p where p.playerName=name").getResultList().get(0);
    }

    public Player newPlayer(String name) {
        return null;
    }

}

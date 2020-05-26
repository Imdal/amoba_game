package game;

import javax.transaction.Transactional;
import util.jpa.GenericJpaDao;



public class PlayerDao extends GenericJpaDao<Player> {
    public PlayerDao() {
        super(Player.class);
    }

@Transactional
    public Player findPlayer(String name){
        if(entityManager.createQuery("Select playerName From Player p where p.playerName=name").getResultList().isEmpty()){
            return new Player(name);
        }
        else return (Player) entityManager.createQuery("Select playerName From Player p where p.playerName=name").getResultList().get(0);
    }


}

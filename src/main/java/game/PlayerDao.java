package game;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import util.jpa.GenericJpaDao;



public class PlayerDao extends GenericJpaDao<Player> {
    public PlayerDao() {
        super(Player.class);
    }

    public EntityManager entityManager;

    @Transactional
    public Player findPlayer(String name) {
        if (entityManager.createQuery("Select playerName From Player p where p.playerName=name").getResultList().size() != 0) {
            return (Player) entityManager.createQuery("Select playerName From Player p where p.playerName=name").getResultList().get(0);
        } else {
            insertPlayer(new Player(name));
            return new Player(name);
        }
    }

    public void insertPlayer(Player player) {
        entityManager.createNativeQuery("INSERT INTO Player (playerName,games,wins,winRow,bestWinRow) VALUES (?,?,?,?,?)")
                .setParameter(1, player.getPlayerName())
                .setParameter(2, player.getGames())
                .setParameter(3, player.getWins())
                .setParameter(4, player.getWinRow())
                .setParameter(5, player.getBestWinRow())
                .executeUpdate();
    }

}

package game.main_and_methods

import game.npc_and_player.Entities
import game.npc_and_player.Monster
import game.npc_and_player.Player



fun main() {

    val Player = Player()
    val Monster = Monster()
    val Entities = Entities()

    Monster.run {
        Player.begin()
        monster_random_or_no(Player.attack, Player.shield, Player.health)
    }
    Entities.who_hits(
        Player.name,
        Player.attack,
        Player.shield,
        Player.health,
        Monster.attack,
        Monster.shield,
        Monster.health
        )
}

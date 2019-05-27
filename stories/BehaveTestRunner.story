Scenario: Wylogowywanie

Given Jestem zalogowany jako admin
When Wyloguje się
Then Zobaczę przycisk zaloguj

Scenario: Nie zaloguje sie

Given Jestem wylogowany
When Spróbuję się zalogować danymi <login> <password>
Then Zobaczę komunikat o błędzie
Examples:
|login          |password  |
|admin@adnin.com|admin1    |
|mod@mid.com    |moderator1|
|user@user.com  |user123   |

Scenario: Zaloguje się

Given Jestem wylogowany
When Spróbuję się zalogować danymi <login> <password>
Then Zobaczę mój login <message>
Examples:
|login          |password  |message               |
|admin@admin.com|admin1    |Hello admin@admin.com!|
|mod@mod.com    |moderator1|Hello mod@mod.com!    |
|user@user.com  |user12    |Hello user@user.com!  |


Scenario: Wejdę na stronę główną

Given Jestem wylogowany
When spróbuję wejść na stronę
Then Zobaczę tytuł strony głównej

Scenario: Nie dodam niepoprawnych autorów

Given Jestem zalogowany jako admin na stronie autorów
When Spróbuję dodać niepoprawnych autorów
Then Zobaczę komunikat o niepowodzeniu


Scenario: Nie dodam autorów bez imienia

Given Jestem zalogowany jako admin na stronie autorów
When Spróbuję dodać autora bez imienia
Then Zobaczę komunikat o pustym polu

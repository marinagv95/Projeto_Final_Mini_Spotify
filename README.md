
# Mini Spotify - Sistema de Streaming de Músicas em Java

## Descrição
Este projeto é um sistema orientado a objetos que simula funcionalidades básicas de uma plataforma de streaming de músicas. Ele foi desenvolvido para aplicar conceitos de **Programação Orientada a Objetos (POO)**, como **encapsulamento, herança e polimorfismo**, além de utilizar estruturas de dados como `List`, `Set` e `Map` para organizar informações. O sistema também faz uso de **tratamento de exceções** para garantir a robustez das operações.

O projeto contempla **músicas, podcasts e audiobooks**, permitindo que os usuários criem playlists, gerenciem suas mídias e explorem um catálogo de conteúdo disponível.

---

## Estrutura do Projeto

src/
└── br.com.maisunifacisa
├── enums
│ ├── GeneroMusical.java
│ └── TipoMidia.java
├── excecao
│ ├── EmailInvalidoException.java
│ ├── MidiaNaoEncontradaException.java
│ ├── OpcaoInvalidaException.java
│ ├── PlaylistVaziaException.java
│ └── UsuarioInvalidoException.java
├── menus
│ ├── MenuCatalogo.java
│ ├── MenuUsuario.java
│ ├── SubmenuMidiasUsuario.java
│ └── SubmenuPlaylistUsuario.java
└── models
├── Audiobook.java
├── Catalogo.java
├── Midia.java
├── Musica.java
├── Playlist.java
├── Podcast.java
├── Sistema.java
└── Usuario.java
Main.java



---

## Funcionalidades

### Usuário
- Cadastro com **nome** e **e-mail**.
- Criação e gerenciamento de **playlists**.
- Adição e remoção de mídias em playlists.
- Visualização das playlists e das mídias contidas.

### Mídias
- Cada mídia possui **título, artista, duração e gênero**.
- Armazenamento em um **catálogo geral**.
- Tipos de mídia: **Música, Podcast, Audiobook**.

### Playlist
- Cada playlist possui um **nome** e pertence a um único usuário.
- Contém uma **lista de mídias**.
- Permite calcular a **duração total** da playlist.

### Catálogo
- Armazena todas as mídias cadastradas.
- Permite buscar mídias por **título, artista ou gênero**.

### Gêneros Musicais
- Enumeração `GeneroMusical` com valores como: `ROCK`, `POP`, `MPB`, `JAZZ`, `CLASSICA`, etc.

---

## Tecnologias
- **Java 17+**
- Estruturas de dados: `List`, `Set`, `Map`
- Tratamento de exceções customizadas
- Padrões de **POO**: encapsulamento, herança, polimorfismo

---

## Como executar
1. Clone o repositório:
```bash
git clone <git@github.com:marinagv95/Projeto_Final_Mini_Spotify.git>

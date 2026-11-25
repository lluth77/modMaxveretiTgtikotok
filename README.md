# Social Blocks (Fabric 1.21.11)

Мод добавляет 4 блока: `purple_block`, `blue_block`, `black_block`, `smile_block`.
Они лежат во вкладке «Строительные блоки», ломаются киркой за 1.5 сек (как камень) и выпадают сами.

## Текстуры

- `smile_block` уже с вашим смайликом.
- Остальные три сейчас однотонные заглушки. Вставьте свои картинки:

```
pip install pillow
python tools/make_texture.py картинка1.jpg purple_block
python tools/make_texture.py картинка2.jpg blue_block
python tools/make_texture.py картинка3.jpg black_block
```

Либо вручную положите PNG в `src/main/resources/assets/socialblocks/textures/block/`
(имя файла = имя блока, квадрат, лучше 64x64).

## Сборка .jar (без установки Java на ПК)

1. Создайте репозиторий на GitHub и загрузите туда все файлы проекта (включая папку `.github`).
2. Вкладка **Actions** → workflow **build** → дождитесь зелёной галочки.
3. Внутри запуска скачайте артефакт `social-blocks`, в нём `social-blocks-1.0.0.jar`.

## Установка

- **Aternos:** Fabric 1.21.11 → Моды → загрузить `.jar` и **Fabric API**.
- **Игроки:** тот же `.jar` + Fabric API в папку `mods`, иначе текстуры/блоки не отобразятся.

## Если сборка падает

Откройте `gradle.properties` и подставьте актуальные версии с https://fabricmc.net/develop
(`yarn_mappings`, `loader_version`, `fabric_version`).

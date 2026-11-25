"""Превращает любую вашу картинку в текстуру блока.

Использование (нужен Python и Pillow: pip install pillow):
    python tools/make_texture.py my_picture.jpg purple_block
    python tools/make_texture.py my_picture.jpg blue_block
    python tools/make_texture.py my_picture.jpg black_block
    python tools/make_texture.py my_picture.jpg smile_block

Результат: src/main/resources/assets/socialblocks/textures/block/<имя>.png (64x64).
После этого пересоберите мод.
"""
import sys
from pathlib import Path
from PIL import Image

SIZE = 64

def main():
    if len(sys.argv) != 3:
        print(__doc__)
        sys.exit(1)
    src, name = Path(sys.argv[1]), sys.argv[2]
    root = Path(__file__).resolve().parent.parent
    out = root / "src/main/resources/assets/socialblocks/textures/block" / f"{name}.png"
    out.parent.mkdir(parents=True, exist_ok=True)

    img = Image.open(src).convert("RGBA")
    side = min(img.size)
    left = (img.width - side) // 2
    top = (img.height - side) // 2
    img = img.crop((left, top, left + side, top + side)).resize((SIZE, SIZE), Image.LANCZOS)
    img.save(out)
    print(f"Сохранено: {out}")

if __name__ == "__main__":
    main()

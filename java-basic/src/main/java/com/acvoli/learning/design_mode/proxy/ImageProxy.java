package com.acvoli.learning.design_mode.proxy;

class ImageProxy implements Image {
  private HighResolutionImage highResolutionImage;

  ImageProxy(HighResolutionImage highResolutionImage) {
    this.highResolutionImage = highResolutionImage;
  }

  @Override
  public void showImage() {
    while (!highResolutionImage.isLoad()) {
      try {
        System.out.println(
            "Temp Image: "
                + highResolutionImage.getWidth()
                + " "
                + highResolutionImage.getHeight());
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    highResolutionImage.showImage();
  }
}

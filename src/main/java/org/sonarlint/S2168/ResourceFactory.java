package org.sonarlint.S2168;

class ResourceFactory {
  private volatile Resource resource;

  public Resource getResource() {
    Resource localResource = resource;
    if (localResource == null) {
      synchronized (this) {
        localResource = resource;
        if (localResource == null) {
          resource = localResource = new Resource();
        }
      }
    }
    return localResource;
  }

  static class Resource {

  }
}

<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    /* 移除min-height: 100vh以避免与布局组件冲突 */
    display: flex;
    align-items: center;
  }
}
</style>

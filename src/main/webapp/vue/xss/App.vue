<template>
    <div id="app">
        <h1>サニタイズなし</h1>
        <p>{{ mastache }}</p>
        <p v-html="vhtml"></p>
        <h1>サニタイズあり</h1>
        <p>{{ $sanitize(mastache) }}</p>
        <p v-html="$sanitize(vhtml)"></p>
    </div>
</template>

<script>
  export default {
    name: 'app',
    data() {
      return {
        mastache: 'mastache:<br><a onmouseover=alert(document.cookie)>click me!</a>',
        vhtml: 'vhtml:<br><a onmouseover=alert(document.cookie)>click me!</a>'
      }
    }
  }
</script>
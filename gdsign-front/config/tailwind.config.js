module.exports = {
  important: true,
  purge: ["../src/assets/style/**/*.less", "../src/**/*.vue", "../src/**/*.js"],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      spacing: {
        "18": "4.5rem"
      },
      width: {
        "screen-2/3": "66.666667vw",
        "screen-1/3": "33.333333vw",
        "screen-3/5": "60vw",
        "screen-2/5": "40vw"
      }
    }
  },
  variants: {
    extend: {}
  },
  plugins: []
};

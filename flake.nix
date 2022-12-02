{
  inputs = {
    nixpkgs = { url = "github:NixOS/nixpkgs/nixpkgs-unstable"; };
    flake-utils = { url = "github:numtide/flake-utils"; };
  };

  outputs = inp:
    inp.flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = import inp.nixpkgs { inherit system; };
      in
      {
        devShell = pkgs.mkShell {
          buildInputs = with pkgs; [
            ammonite
            bloop
            coursier
            metals
            sbt
            scalafmt
          ];
        };
      }
    );
}
